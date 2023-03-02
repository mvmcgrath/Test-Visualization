import VisualizationRow from './VisualizationRow'

//Dummy data
const rows = [{ text: 'Visualization 1', id: 1 }, { text: 'Visualization 2', id: 2 }]

const VisualizationRows= () => {
  return(
    <div>
      {rows.map((row) =>
        <VisualizationRow key={row.id} row={row} />
      )}
    </div>
  )
}

export default VisualizationRows