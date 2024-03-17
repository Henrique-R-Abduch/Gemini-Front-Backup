import Footer from '@/components/footer'
import NavBar from '@/components/navbar'
import Image from 'next/image'
import Link from 'next/link'

export default function Home() {
  return (
    <>
    <NavBar/>
    
    <main className='container bg-slate-800 flex mt-16 mx-auto rounded p-4 items-center'>
      <div className='h-10 w-10 rounded-full overflow-hidden'>
        <img src="https://github.com/Henrique-R-Abduch.png" alt="avatar do usuário"></img>
      </div>
      <h2 className='font-bold justify-end mx-4'>Bem Vindo</h2>
      </main>
      <div className=''>
        <ul className='justify-around flex-column gap-16 container bg-slate-800 mt-16 mx-auto rounded p-4 items-center font-semibold'>
          <li className='bg-slate-600 p-10 rounded mx-2 my-2 justify-center flex'><a href="/productregistration">Product Registration</a></li>
          <li className='bg-slate-600 p-10 rounded mx-2 my-2 justify-center flex'><a href="/InventoryManagement">Inventory Management</a></li>
          <li className='bg-slate-600 p-10 rounded mx-2 my-2 justify-center flex'><a href="#">Transaction Logging</a></li>
          <li className='bg-slate-600 p-10 rounded mx-2 my-2 justify-center flex'><a href="#">Categories And Tags</a></li>
          <li className='bg-slate-600 p-10 rounded mx-2 my-2 justify-center flex'><a href="#">Shipment Tracking</a></li>
        </ul>
      </div>
      <Footer/>
    </>
  )
}
