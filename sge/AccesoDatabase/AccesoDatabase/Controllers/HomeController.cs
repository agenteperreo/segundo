using AccesoDatabase.Models;
using AccesoDatabase.Models.ViewModels;
using BL;
using BL.Listados;
using BL.Manejadoras;
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

        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public ActionResult listadoPersonas()
        {
            try
            {
                List<clsPersona> listadoCompPersonas = clsListaPersonasBL.listadoCompletoPersonasBL();
                return View(listadoCompPersonas);
            } catch (Exception ex)
            {
                ViewBag.Error = "Ha ocurrido un error. Intentelo de nuevo mas tarde";
                return View("Error");
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public ActionResult Delete(int id)
        {
            try
            {
                return View(HandlerPersonaBL.getPersonaId(id));
            } catch (Exception ex)
            {
                ViewBag.Error = "Ha ocurrido un error";
                return View("Error");
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="oPersona"></param>
        /// <returns></returns>
        [ActionName("Delete")]
        [HttpPost]
        public IActionResult DeletePost(int id) 
        {
            try
            {
                int numeroFilas = HandlerPersonaBL.deletePersonaBL(id);

                if(numeroFilas == 0)
                {
                    ViewBag.Info = "No existe esa persona";
                } 
                else if(numeroFilas == -1)
                {
                    ViewBag.Info = "Hoy es miercoles y no se puede borrar";
                }
                else
                {
                    ViewBag.Info = "La persona se ha borrado correctamente";
                }

                return View("listadoPersonas", clsListaPersonasBL.listadoCompletoPersonasBL());
            } catch 
            {
                ViewBag.Error = "Ha ocurrido un erro en la base de datos";
                return View("Error");
            }            
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public ActionResult Details(int id)
        {
            try
            {
                clsPersona oPersona = HandlerPersonaBL.getPersonaId(id);
                return View(oPersona);
            }
            catch (Exception ex)
            {
                ViewBag.Error = "Ha ocurrido un error";
                return View("Error");
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        [HttpPost]
        public ActionResult Details()
        {
            return View();
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public ActionResult Edit(int id)
        {
            clsPersona oPersona = HandlerPersonaBL.getPersonaId(id);
            
            listadoDepartamentoConPersonasVM vm = new listadoDepartamentoConPersonasVM(oPersona);
            return View(vm);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="oPersona"></param>
        /// <returns></returns>
        [HttpPost]
        public ActionResult Edit(clsPersona oPersona)
        {
            HandlerPersonaBL.editPersonaBL(oPersona);

            return RedirectToAction("listadoPersonas");
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public ActionResult Create()
        {
            return View();
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="oPersona"></param>
        /// <returns></returns>
        [HttpPost]
        public ActionResult Create(clsPersona oPersona)
        {
            DAL.clsCreatePersona.createPersona(oPersona);

            return RedirectToAction("listadoPersonas");
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