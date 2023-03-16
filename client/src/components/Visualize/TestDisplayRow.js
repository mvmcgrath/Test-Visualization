import styled from 'styled-components'

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

const TestDisplayRow = ({ testCase, onSelect }) => {
  const onClick = () => {
    onSelect(testCase.testCaseId)
  }

  return(
    <StyledTestCase onClick={onClick} className="d-flex justify-content-center align-items-center">
      <StyledHeader>{testCase.methodName}</StyledHeader>
    </StyledTestCase>
  )
}

export default TestDisplayRow