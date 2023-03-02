import styled from 'styled-components'
import { Link } from 'react-router-dom'

const StyledDiv = styled.div`
  color: white;
  background-color: #4b5054;
  border-bottom: 3px solid white;
  height:80px;
  display: flex;
  align-items: center;
  justify-content: center;
`

const StyledLink = styled(Link)`
  text-decoration: none;
  color: white;
`

const VisualizationRow = ({ row }) => {
  return(
    <StyledLink to={`/visualization/${row.id}`}>
      <StyledDiv>
        <h2>{row.text}</h2>
      </StyledDiv>
    </StyledLink>
  )
}

export default VisualizationRow