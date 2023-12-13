using BL.Listados;
using BL.Manejadoras;
using Entidades;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace AccesoDatabase.Controllers.API
{
    [Route("api/[controller]")]
    [ApiController]
    public class DepartamentosController : ControllerBase
    {
        // GET: api/<DepartamentosController>
        [HttpGet]
        public IEnumerable<clsDepartamento> Get()
        {
            return clsListaDepartamentosBL.listadoCompletoDepartamentosBL();
        }

        // GET api/<DepartamentosController>/5
        [HttpGet("{id}")]
        public Task Get(int id)
        {
            return HandlerPersonaBL.deletePersonaBL(id);
        }
    }
}
