import VisualizationRow from './VisualizationRow'
import { useState, useEffect } from 'react'

import visualizationService from '../../services/visual.js'

const VisualizationRows = ({ user }) => {
  const [visualizations, setVisualizations] = useState([])

  useEffect(() => {
    visualizationService.getAll().then(returnedVisuals => {
      setVisualizations(returnedVisuals.filter(visual => visual.userId === user.userId))
    })
  }, [])

  return(
    <div>
      {visualizations.map((visual) =>
        <VisualizationRow key={visual.visualizationId} row={visual} />
      )}
    </div>
  )
}

export default VisualizationRows