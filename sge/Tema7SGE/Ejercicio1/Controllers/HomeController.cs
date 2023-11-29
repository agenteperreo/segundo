using Ejercicio12y3.Models.Entidades;
using Ejercicio12y3.Models.DAL;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using Ejercicio12y3.Models.ViewModels;
using Ejercicio12y3.Models;

namespace Ejercicio12y3.Controllers
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
            DateTime tiempo = DateTime.Now;

            int hora = tiempo.Hour;

            string saludo = "";

            if(hora >= 6 && hora <= 12) 
            {
                saludo = "Buenos dias";
            } 
            else if(hora > 12 && hora <= 20)
            {
                saludo = "Buenas tardes";
            }
            else
            {
                saludo = "Buenas noches";
            }

            clsPersona yo = new clsPersona("Isaac", "García Carmona", "123456789");

            ViewData["Saludo"] = saludo;
            ViewBag.Date = tiempo;

            return View(yo);
        }

        public IActionResult listadoPersonas()
        {
            try
            {
                return View(clsListadoPersona.listadoCompletoPersonas());
            }
            catch (Exception ex)
            {
                ViewBag.Error = "Ha ocurrido un error, intentelo de nuevo mas tarde";
                return View("Error");
            }
            
        }

        public IActionResult FormularioPersona() 
        {
            EditarPersonaVM editPersona = new();

            return View(editPersona);
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
