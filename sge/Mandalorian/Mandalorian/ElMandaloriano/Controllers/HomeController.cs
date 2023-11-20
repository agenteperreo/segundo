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
        /// </summary>
        /// <returns></returns>
        public IActionResult Index()
        {
            IndexViewModel ivm = new IndexViewModel(new clsMision(), clsListaMisiones.getListaCompletaMisiones());
            return View(ivm);
        }
        [HttpPost]
        public IActionResult Index(int IdMision)
        {   //Recibo de la vista el Id de la misión seleccionada, y le devuelvo la lista con la descripción de la misión.
            IndexViewModel ivm = new IndexViewModel();
            ivm.ListaMisiones = clsListaMisiones.getListaCompletaMisiones();
            ivm.Mision = obtenerMision.obtenerMisionId(IdMision);
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