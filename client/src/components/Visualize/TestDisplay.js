import styled from 'styled-components'

const StyledButton = styled.button`
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
`

const StyledTestDisplay = styled.div`
  width: 400px;
  height: 650px;
  border: 3px solid white;
`

const StyledTestCase = styled.div`
    width: 400px;
    height: 100px;
    border-bottom: 3px solid white;
    cursor: pointer;
`

const StyledHeader = styled.h2`
    font-size: 1.3rem;
    overflow-wrap: anywhere;
`


const TestDisplay = () => {
  return (
    <div className="d-flex justify-content-flex-start align-items-center flex-column">
      <StyledTestDisplay className="bg-dark d-flex justify-content-flex-start align-items-center flex-column">
        <StyledTestCase className="d-flex justify-content-center align-items-center">
          <StyledHeader>Calculator.calculatorCanAdd</StyledHeader>
        </StyledTestCase>
      </StyledTestDisplay>
      <StyledButton>Delete</StyledButton>
    </div>
  )
}

export default TestDisplay