using Ejercicio3.Models;
using Ejercicio3.Models.Entities;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace Ejercicio3.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Editar(clsPersona persona)
        {
            return View("PersonaModificada", persona);
        }

        public IActionResult Editar()
        {
            clsPersona persona = new clsPersona();
            persona.Nombre = "Pedro";
            persona.Apellidos = "GB";
            persona.Tlfno = "604357782";
            return View(persona);
        }

        public IActionResult PersonaModificada()
        {
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