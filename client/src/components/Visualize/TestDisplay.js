import styled from 'styled-components'
import TestDisplayRow from './TestDisplayRow'

const StyledTestDisplay = styled.div`
  width: 400px;
  height: 650px;
  border: 3px solid white;
`


const TestDisplay = ({ onSelect, testCases }) => {

  return (
    <div className="d-flex justify-content-flex-start align-items-center flex-column">
      <StyledTestDisplay className="bg-dark d-flex justify-content-flex-start align-items-center flex-column">
        {testCases.map(testCase =>
          <TestDisplayRow key={testCase.testCaseId} testCase={testCase} onSelect={onSelect} />
        )}
      </StyledTestDisplay>
    </div>
  )
}

export default TestDisplay