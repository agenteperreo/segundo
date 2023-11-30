using BL.Manejadoras;
using Entidades;
using ExamenSGE.Models;
using ExamenSGE.Models.ViewModels;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace ExamenSGE.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public ActionResult Index()
        {
            
            return View();
        }

        [ActionName("Index")]
        [HttpPost]
        public IActionResult IndexPost()
        {
            return View();
        }

        public ActionResult CambiarPrecio(int id)
        {
            clsModelos oModelo = clsHandlerBL.getModeloByIdBL(id);

            return View(oModelo);
        }

        [ActionName("CambiarPrecio")]
        [HttpPost]
        public IActionResult CambiarPrecioPost(clsModelos oModelo)
        {
            //clsHandlerBL.editarPrecioModeloBL(oModelo);

            return View();
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
