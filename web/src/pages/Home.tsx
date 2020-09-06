import React, { useEffect, useState } from 'react'

import api from '../services/api'

function Home() {
    const [dados, setDados] = useState([])

    useEffect(() => {
        async function loadData() {
            const response = await api.get('/')

            setDados(response.data)
        }

        loadData()
    }, [])

        console.log(dados[0])

    return (
        <div id="app">
            {/* <tr key={dados[0].id}>{dados}</tr> */}
        </div>
    )
}

export default Home
