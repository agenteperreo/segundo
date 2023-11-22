using ElMandaloriano.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using Biblioteca;
using ElMandaloriano.Models.DAL;
using ElMandaloriano.Models.ViewModels;

namespace ElMandaloriano.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// Le paso a la vista una lista de las misiones, que he declarado antes del viewmodel antes para poder usarla en todo el controlador.
        /// Precondición: Ninguna
        /// Postcondición: Ninguna
        /// </summary>
        /// <returns>Un IndexViewModel con un objeto mision vacío y la lista de misiones</returns>
        public IActionResult Index()
        {
            IndexViewModel ivm = new IndexViewModel(new clsMision(), clsListaMisiones.getListaCompletaMisiones());
            return View(ivm);
        }

        /// <summary>
        /// Le paso un id y la lista de misiones y llama a la funcion obtenerMisionId par mandar una vista con la mision encontrada
        /// Precondición: Que el id no sea 0
        /// Postcondición: Ninguna
        /// </summary>
        /// <param name="Id"></param>
        /// <param name="listaMisiones"></param>
        /// <returns>Un indexViewModel con la mision encontrada y la lista de misiones completas</returns>
        [HttpPost]
        public IActionResult Index(int Id, List<clsMision> listaMisiones)
        {   //Recibo de la vista el Id de la misión seleccionada, y le devuelvo la lista con la descripción de la misión.
            IndexViewModel ivm = new IndexViewModel();
            ivm.ListaMisiones = clsListaMisiones.getListaCompletaMisiones(); 
            ivm.Mision = obtenerMision.obtenerMisionId(Id, listaMisiones);
            return View(ivm);
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}