import styled from 'styled-components'
import TestDisplayRow from './TestDisplayRow'

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


const TestDisplay = ({ onSelect, onDelete, testCases }) => {
  const onClick = () => {
    onDelete()
  }

  return (
    <div className="d-flex justify-content-flex-start align-items-center flex-column">
      <StyledTestDisplay className="bg-dark d-flex justify-content-flex-start align-items-center flex-column">
        {testCases.map(testCase =>
          <TestDisplayRow key={testCase.testCaseId} testCase={testCase} onSelect={onSelect} />
        )}
      </StyledTestDisplay>
      <StyledButton onClick={onClick}>Delete</StyledButton>
    </div>
  )
}

export default TestDisplay