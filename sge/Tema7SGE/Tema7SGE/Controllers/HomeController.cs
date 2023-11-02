using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using Tema7SGE.Models;
using Tema7SGE.Models.DAL;
using Tema7SGE.Models.Entidades;

namespace Tema7SGE.Controllers
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
            if(DateTime.Now.Hour<12)
            {
                ViewData["Saludo"] = "Buenos dias";
            } 
            else if(DateTime.Now.Hour>=12 && DateTime.Now.Hour<20)
            {
                ViewData["Saludo"] = "Buenas tardes";
            } 
            else
            {
                ViewData["Saludo"] = "Buenas noches";
            }

            ViewBag.Fecha = DateTime.Now;

            clsPersona clsPersona = new clsPersona();
            clsPersona.nombre = "Isaac";
            clsPersona.apellidos = "García Carmona";
            clsPersona.telefono = "123456789";

            return View(clsPersona);

            
        }

        public IActionResult listadoPersonas()
        {
            try
            {
                return View(ListaPersonas.listadoCompletoPersonas());
            } catch (Exception ex) { //Mandar a otra vista de error
                                     
                return View(ListaPersonas.listadoCompletoPersonas());
            }
            
        }

    }
}