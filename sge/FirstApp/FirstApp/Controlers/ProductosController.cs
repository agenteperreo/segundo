using Microsoft.AspNetCore.Mvc;

namespace FirstApp.Controlers
{
    public class ProductosController : Controller
    {
        public IActionResult ListadoProductos()
        {
            return View();
        }

        
    }
}
