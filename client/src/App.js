import { Routes, Route } from 'react-router-dom'

import Home from './components/Home'
import Navigation from './components/Navigation'

const App = () => {
  return (
    <div>
      <Navigation />
      <div>
        <Routes>
          <Route path="/" element={<Home />} />
        </Routes>
      </div>
    </div>
  )
}

export default App
