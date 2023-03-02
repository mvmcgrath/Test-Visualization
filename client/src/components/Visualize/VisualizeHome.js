import { Container } from 'react-bootstrap'
import styled from 'styled-components'
import { Link } from 'react-router-dom'

import VisualizationRows from './VisualizationRows'

const StyledDiv = styled.div`
  width: 1200px;
  height: 600px;
  margin-top: 50px;
  color: white;
  border: 3px solid white;
`

const StyledButton = styled.div`
  font-size: 1.5rem;
  border: 3px solid white;
  border-radius: 10px;
  background-color: #0d6efd;
  padding: 10px;
  color: white;
  min-height: 80px;
  width: 340px;
  cursor: pointer;
  margin-bottom: 10px;
  margin-top: 30px;
  display: flex;
  align-items: center;
  justify-content: center;
`

const StyledLink = styled(Link)`
  text-decoration: none;
`

const VisualizeHome = ({ user }) => {
  return(
    <Container fluid bg="dark" className="d-flex align-items-center flex-column">
      <StyledDiv className="bg-dark">
        <VisualizationRows user={user}/>
      </StyledDiv>
      <StyledLink to={'/upload'}>
        <StyledButton>
          Create New Visualization
        </StyledButton>
      </StyledLink>
    </Container>
  )
}

export default VisualizeHome