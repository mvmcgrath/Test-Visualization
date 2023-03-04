import { Navbar, Nav, Container, Button } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import styled from 'styled-components'

const StyledLink = styled(Link)`
  padding: 5px;
  text-decoration: none;
  color: white;
  font-size: 1.3rem;
`

const StyledDiv = styled.div`
  display: flex;
  align-items: center;
`

const StyledName = styled.span`
  color: white;
  margin-right: 30px;
  font-size: 1.3rem;
`

const Navigation = ({ user, handleLogout }) => {
  return(
    <Navbar collapseOnSelect expand="xxl" bg="dark" variant="dark">
      <Container>
        <Navbar.Brand>🧪</Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#" as="span">
              <StyledLink to="/">Home</StyledLink>
            </Nav.Link>
            <Nav.Link href="#" as="span">
              <StyledLink to="/visualize">Visualize</StyledLink>
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
        <Navbar className="justify-content-end">
          <Nav.Link className="justify-content-end" href="#" as="span">
            {user
              ?
              <StyledDiv>
                <StyledName>{user.username}</StyledName>
                <Button onClick={handleLogout}>Logout</Button>
              </StyledDiv>
              : <StyledLink to="/">Login</StyledLink>
            }
          </Nav.Link>
        </Navbar>
      </Container>
    </Navbar>
  )
}

export default Navigation