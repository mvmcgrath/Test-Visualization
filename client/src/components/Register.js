import { Container, Form, Button } from 'react-bootstrap'
import styled from 'styled-components'
import { useNavigate } from 'react-router-dom'
import { useState } from 'react'
import registerService from '../services/register'

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

const Register = () => {
  const navigate = useNavigate()
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')

  const onSubmit = async (event) => {
    event.preventDefault()

    try {
      await registerService.register({
        username,
        password
      })
      navigate('/')
    } catch (exception) {
      console.error(exception)
    }
  }

  return(
    <Container fluid bg="dark" className="d-flex justify-content-center">
      <StyledDiv className="bg-dark p-4 d-flex justify-content-center">
        <div className="w-50">
          <Form onSubmit={onSubmit}>
            <Form.Group>
              <StyledVerticalFlex>
                <div>
                  <Form.Label>Username:</Form.Label>
                  <Form.Control
                    type="text"
                    name="username"
                    onChange={({ target }) => setUsername(target.value)}
                  />
                </div>
                <div>
                  <Form.Label>Password:</Form.Label>
                  <Form.Control
                    type="password"
                    name="password"
                    onChange={({ target }) => setPassword(target.value)}
                  />
                </div>
                <Button variant="primary" type="submit">
                  Register
                </Button>
              </StyledVerticalFlex>
            </Form.Group>
          </Form>
        </div>
      </StyledDiv>
    </Container>
  )
}

export default Register