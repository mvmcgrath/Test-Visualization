import styled from 'styled-components'
import { Tab, Tabs } from 'react-bootstrap'

const StyledCodeDisplay = styled.div`
  width: 1200px;
  height: 650px;
  border: 3px solid white;
`

const StyledButtonDisplay = styled.div`
    gap: 50px;
`

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

const CodeDisplay = ({ classFiles }) => {
  return (
    <div>
      <StyledCodeDisplay className="bg-dark">
        <Tabs className="mb-0">
          {classFiles.map((classFile) =>
            <Tab key={classFile.reportClassId} eventKey={classFile.className} title={classFile.className.concat('.java')} >
              {classFile.htmlReport}
            </Tab>
          )}
        </Tabs>
      </StyledCodeDisplay>
      <StyledButtonDisplay className="d-flex justify-content-center align-items-center">
        <StyledButton>{'<-'}</StyledButton>
        <StyledButton>{'->'}</StyledButton>
      </StyledButtonDisplay>
    </div>
  )
}

export default CodeDisplay