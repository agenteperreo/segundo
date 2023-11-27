using AccesoDatabase.Models;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using System.Diagnostics;

namespace AccesoDatabase.Controllers
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

            SqlConnection miConexion = new SqlConnection();
            

            ViewBag.ConnectionState = "No se ha intentado conectar";

            try
            {
                miConexion.ConnectionString = "server=baseisaacazure.database.windows.net;database=IsaacAzure;uid=prueba;pwd=fernandoG321;trustServerCertificate=true";

                miConexion.Open();

                ViewBag.ConnectionState = $"Conectado: {miConexion.State}";
            }
            catch (Exception ex)
            {
                ViewBag.ConnectionState = $"Error al conectar: {ex.Message}";
            }

            return View();
        }

        public ActionResult listadoPersonas()
        {
            try
            {
                List<clsPersona> listadoCompPersonas = DAL.clsListadoPersonas.listadoCompletoPersonas();
                return View(listadoCompPersonas);
            } catch (Exception ex)
            {
                ViewBag.Error = "Ha ocurrido un error. Intentelo de nuevo mas tarde";
                return View("Error");
            }
        }

        public ActionResult Delete(int id)
        {
            try
            {
                clsPersona oPersona = DAL.personaPorId.obtenerPersonaId(id);
                return View(oPersona);
            } catch (Exception ex)
            {
                ViewBag.Error = "Ha ocurrido un error";
                return View("Error");
            }
        }

        [HttpPost]
        public ActionResult Delete() 
        {
            return RedirectToAction("borrar");
            
        }

        public ActionResult borrar(clsPersona persona) 
        {
            try {

                int cantRows = DAL.clsDeletePersona.deletePersonaDAL(persona.Id);

                ViewBag.cantRows = cantRows;

                return View();

            }
            catch (Exception ex)
            {
                ViewBag.Error = "Ha ocurrido un error";
                return View("Error");
            }
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