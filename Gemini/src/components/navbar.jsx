import Link from "next/link";

export default function NavBar() {
    return (
      <div className="relative group">
        <div className="absolute inset-0.5 bg-gradient-to-r from-blue-500 to-purple-600 rounded-lg blur opacity-75 group-hover:opacity-100 transition duration-1000 group-hover:duration-200"></div>
        <nav className="relative bg-slate-800 items-center justify-between px-8 py-6">
      <ul className='flex items-end gap-16 group-hover:text-gray-100 transition duration-200'>
        <li><Link href="/"><h1 className='text-2xl'>Stock Helper</h1></Link></li>
        <li className='flex'><a href="#">Settings</a></li>
        <li className='flex'><a href="#">Logout</a></li>
      </ul>
    </nav>
    </div>
    )
}