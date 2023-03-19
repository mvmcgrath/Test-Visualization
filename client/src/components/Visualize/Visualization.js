import styled from 'styled-components'
import { useParams, useNavigate } from 'react-router-dom'
import { useState, useEffect } from 'react'

import CodeDisplay from './CodeDisplay'
import TestDisplay from './TestDisplay'
import reportClassService from '../../services/reportClass'
import testCaseService from '../../services/testCase'
import visualService from '../../services/visual'

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
  const navigate = useNavigate()
  const visualizationId = useParams().visualizationId

  const [testCases, setTestCases] = useState([])
  const [classFiles, setClassFiles] = useState([])
  const [executionOrder, setExecutionOrder] = useState([])
  const [selectedIndex, setSelectedIndex] = useState(0)


  const onSelect = (testCaseId) => {
    reportClassService.getReportClassByTestCase(testCaseId).then(returnedClassFiles => {
      testCaseService.getTestCase(testCaseId).then(returnedTestCase => {
        setSelectedIndex(0)
        setClassFiles(returnedClassFiles)
        setExecutionOrder(returnedTestCase.executionOrder)
      })
    })
  }

  const onDelete = () => {
    visualService.deleteVisual(visualizationId).then(() => {
      navigate('/')
    })
  }

  const onIndexChange = (forward) => {
    if (forward && selectedIndex !== executionOrder.length - 1) {
      setSelectedIndex(selectedIndex + 1)
    } else if (!forward && selectedIndex !== 0) {
      setSelectedIndex(selectedIndex - 1)
    }
  }

  useEffect(() => {
    // This filtering is not ideal
    testCaseService.getAll().then(returnedTestCases => {
      setTestCases(returnedTestCases.filter(testCase => testCase.visualizationId === parseInt(visualizationId)))
    })
  }, [])

  return(
    <StyledPageContainer>
      <StyledDisplayContainer>
        <TestDisplay testCases={testCases} onSelect={onSelect} onDelete={onDelete} />
        <CodeDisplay classFiles={classFiles} executionData={executionOrder.length === 0 ? [] : executionOrder[selectedIndex]} onIndexChange={onIndexChange}/>
      </StyledDisplayContainer>
    </StyledPageContainer>
  )
}

export default Visualization