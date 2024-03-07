import Link from "next/link";

export default function Footer() {
    return (
        <div className="relative group">
        <div className="absolute inset-0.5 bg-gradient-to-r from-blue-500 to-purple-600 rounded-lg blur opacity-75"></div>
      <div>
        <footer className='relative bg-slate-800 flex mt-16 mx-auto rounded p-4 items-center justify-center  group-hover:text-gray-100 transition duration-200'>
          <h3>Stock Helper®</h3>
        </footer>
      </div>
     </div>
    )
}