import styled from 'styled-components'
import { useState, useEffect } from 'react'

import TestDisplayRow from './TestDisplayRow'
import testCaseService from '../../services/testCase'

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


const TestDisplay = ({ visualizationId, onSelect }) => {
  const [testCases, setTestCases] = useState([])

  useEffect(() => {
    // This filtering is not ideal
    testCaseService.getAll().then(returnedTestCases => {
      setTestCases(returnedTestCases.filter(testCase => testCase.visualizationId === parseInt(visualizationId)))
    })
  }, [])

  return (
    <div className="d-flex justify-content-flex-start align-items-center flex-column">
      <StyledTestDisplay className="bg-dark d-flex justify-content-flex-start align-items-center flex-column">
        {testCases.map(testCase =>
          <TestDisplayRow key={testCase.testCaseId} testCase={testCase} onSelect={onSelect} />
        )}
      </StyledTestDisplay>
      <StyledButton>Delete</StyledButton>
    </div>
  )
}

export default TestDisplay