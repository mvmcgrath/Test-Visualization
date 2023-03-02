import { Container } from 'react-bootstrap'
import styled from 'styled-components'

import VisualizationRows from './VisualizationRows'

const StyledDiv = styled.div`
  width: 1200px;
  height: 600px;
  margin-top: 50px;
  color: white;
  border: 3px solid white;
`

const StyledButton = styled.button`
  font-size: 1.5rem;
  border: 3px solid white;
  border-radius: 10px;
  background-color: #4b5054;
  padding: 10px;
  color: white;
  min-height: 80px;
  width: 340px;
  cursor: pointer;
  margin-bottom: 10px;
  margin-top: 30px;
`

const VisualizeHome = ({ user }) => {
  return(
    <Container fluid bg="dark" className="d-flex align-items-center flex-column">
      <StyledDiv className="bg-dark">
        <VisualizationRows user={user}/>
      </StyledDiv>
      <StyledButton>Create New Visualization</StyledButton>
    </Container>
  )
}

export default VisualizeHome