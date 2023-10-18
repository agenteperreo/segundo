using Microsoft.AspNetCore.Mvc;

namespace FirstApp.Controlers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        public String Apellido()
        {
            return "García Carmona";
        }

        public IActionResult saludo()
        {
            return View();
        }
    }
}
