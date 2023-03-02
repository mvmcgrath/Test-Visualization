import { Container, Form, Button } from 'react-bootstrap'
import styled from 'styled-components'
import { useState } from 'react'
//import { useNavigate } from 'react-router-dom'

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
  //const navigate = useNavigate()
  const [title, setTitle] = useState('')
  const [sourceFiles, setSourceFiles] = useState([])
  const [testFiles, setTestFiles] = useState([])

  const onSubmit = (event) => {
    event.preventDefault()
    console.log(user)
    console.log(title)
    console.log(sourceFiles)
    console.log(testFiles)
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