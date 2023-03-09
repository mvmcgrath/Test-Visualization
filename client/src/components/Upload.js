import { Container, Form, Button } from 'react-bootstrap'
import styled from 'styled-components'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

import reportService from '../services/report'

const StyledDiv = styled.div`
  width: 600px;
  height: 400px;
  margin-top: 50px;
  color: white;
  border: 3px solid white;
  border-radius: 25px;
`

const StyledVerticalFlex = styled.div`
  display: flex;
  flex-direction: column;
  gap: 20px;
  margin-top: 50px;
`

const Upload = ({ user }) => {
  const navigate = useNavigate()

  const [title, setTitle] = useState('')
  const [sourceFiles, setSourceFiles] = useState([])
  const [testFiles, setTestFiles] = useState([])

  const onSubmit = async (event) => {
    event.preventDefault()

    // Messy promise handling, needs to be refactored
    const sourceFileArray = []
    const testFileArray = []
    const promiseArray = []

    const readFile = (file, isSource) => {
      return new Promise((resolve) => {
        const fileReader = new FileReader()

        fileReader.onload = () => {
          if (/^text\//.test(file.type)) {
            if (isSource) {
              sourceFileArray.push(fileReader.result)
            } else {
              testFileArray.push(fileReader.result)
            }
            resolve()
          }
        }

        fileReader.readAsText(file)
      })
    }

    Array.from(sourceFiles).forEach(file => {
      promiseArray.push(readFile(file, true))
    })

    Array.from(testFiles).forEach(file => {
      promiseArray.push(readFile(file, false))
    })

    Promise.all(promiseArray).then(() => {
      reportService.uploadVisual({ sourceFiles: sourceFileArray, testFiles: testFileArray, title, userId: user.userId }).then((result) => {
        navigate(`/visualization/${result.visualizationId}`)
      })
    })
  }

  return (
    <Container fluid bg="dark" className="d-flex justify-content-center">
      <StyledDiv className="bg-dark d-flex justify-content-center">
        <div className="w-50">
          <Form onSubmit={onSubmit}>
            <Form.Group>
              <StyledVerticalFlex>
                <div>
                  <Form.Label>Visualization Title:</Form.Label>
                  <Form.Control
                    type="text"
                    name="title"
                    onChange={({ target }) => setTitle(target.value)}
                  />
                </div>
                <div>
                  <Form.Label>Source Files:</Form.Label>
                  <Form.Control
                    type="file"
                    multiple
                    onChange={({ target }) => setSourceFiles(target.files)}
                  />
                </div>
                <div>
                  <Form.Label>Test Files:</Form.Label>
                  <Form.Control
                    type="file"
                    multiple
                    onChange={({ target }) => setTestFiles(target.files)}
                  />
                </div>
                <Button variant="primary" type="submit">
                  Upload
                </Button>
              </StyledVerticalFlex>
            </Form.Group>
          </Form>
        </div>
      </StyledDiv>
    </Container>
  )
}

export default Upload