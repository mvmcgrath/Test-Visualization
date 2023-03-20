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

const VisualizeHome = ({ user }) => {
  return(
    <Container fluid bg="dark" className="d-flex align-items-center flex-column">
      <StyledDiv className="bg-dark">
        <VisualizationRows user={user}/>
      </StyledDiv>
    </Container>
  )
}

export default VisualizeHome