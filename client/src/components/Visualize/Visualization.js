import styled from 'styled-components'
import { useParams, useNavigate } from 'react-router-dom'
import { useState } from 'react'

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

  const [classFiles, setClassFiles] = useState([])
  const [executionOrder, setExecutionOrder] = useState([])
  const [selectedIndex, setSelectedIndex] = useState(0)

  const onSelect = (testCaseId) => {
    setSelectedIndex(0)
    reportClassService.getAll().then(returnedClassFiles => {
      setClassFiles(returnedClassFiles.filter(classFile => classFile.testCaseId === testCaseId))
      testCaseService.getTestCase(testCaseId).then(returnedTestCase => {
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

  return(
    <StyledPageContainer>
      <StyledDisplayContainer>
        <TestDisplay visualizationId={visualizationId} onSelect={onSelect} onDelete={onDelete} />
        <CodeDisplay classFiles={classFiles} executionData={executionOrder.length === 0 ? [] : executionOrder[selectedIndex]} onIndexChange={onIndexChange}/>
      </StyledDisplayContainer>
    </StyledPageContainer>
  )
}

export default Visualization