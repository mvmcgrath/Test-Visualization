import { Container, Form, Button } from 'react-bootstrap'
import styled from 'styled-components'
import { Link } from 'react-router-dom'
import { useState } from 'react'

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

const StyledLink = styled(Link)`
  text-decoration: none;
  color: white;
`

const NotificationMessage = styled.p`
  visibility: ${props => props.visible ? 'visible' : 'hidden'};
  color: red;
`

const Login = ({ handleLogin }) => {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [notification, setNotification] = useState(false)

  const onSubmit = async (event) => {
    event.preventDefault()
    try {
      await handleLogin({
        username,
        password
      })
    } catch (exception) {
      setNotification(true)
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
                    onChange={({ target }) => setPassword(target.value)}
                  />
                </div>
                <Button variant="primary" type="submit">
                  Login
                </Button>
                <StyledLink to="/register">Don&#39;t have an account?</StyledLink>
                {notification ? <NotificationMessage visible>Invalid username or password</NotificationMessage> : <NotificationMessage>Invalid username or password</NotificationMessage>}
              </StyledVerticalFlex>
            </Form.Group>
          </Form>
        </div>
      </StyledDiv>
    </Container>
  )
}

export default Login