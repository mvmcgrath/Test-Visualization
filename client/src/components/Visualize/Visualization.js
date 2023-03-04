import styled from 'styled-components'

import CodeDisplay from './CodeDisplay'
import TestDisplay from './TestDisplay'

const StyledPageContainer = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    color: white;
`

const StyledDisplayContainer = styled.div`
    display: flex;
    justify-content: space-evenly;
    align-items: flex-start;
    margin-top: 50px;
`

const Visualization = () => {

  return(
    <StyledPageContainer>
      <StyledDisplayContainer>
        <TestDisplay />
        <CodeDisplay />
      </StyledDisplayContainer>
    </StyledPageContainer>
  )
}

export default Visualization