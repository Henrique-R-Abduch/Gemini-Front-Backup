import { Toaster } from 'react-hot-toast'
import './globals.css'
import { Inter } from 'next/font/google'

async function carregarDados(){
  const url = "http://localhost:3000"
  const resp = await fetch(url, {next: {revalidate: 3600} } )
  if (resp.status !== 200) {
    alert("erro ao mudar dados")
    return
  }
}


const inter = Inter({ subsets: ['latin'] })

export const metadata = {
  title: 'Stock Helper',
  description: 'Stocker helper app',
}

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={inter.className}>{children}
      <Toaster position='bottom-right'/>
      </body>
    </html>
  )
}
