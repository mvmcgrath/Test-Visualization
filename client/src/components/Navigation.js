import { Navbar, Nav, Container } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import styled from 'styled-components'

const StyledLink = styled(Link)`
  padding: 5px;
  text-decoration: none;
  color: white;
  font-size: 1.3rem;
`

const Navigation = () => {
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
      </Container>
    </Navbar>
  )
}

export default Navigation