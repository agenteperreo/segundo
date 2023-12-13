using Microsoft.AspNetCore.Mvc;
using BL;
using BL.Listados;
using Entidades;
using DAL;
using BL.Manejadoras;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace AccesoDatabase.Controllers.API
{
    [Route("api/[controller]")]
    [ApiController]
    public class PersonasController : ControllerBase
    {
        // GET: api/<PersonasController>
        [HttpGet]
        public IEnumerable<clsPersona> Get()
        {
            return clsListaPersonasBL.listadoCompletoPersonasBL();
        }

        // GET api/<PersonasController>/5
        [HttpGet("{id}")]
        public clsPersona Get(int id)
        {
            clsPersona persona = personaPorId.obtenerPersonaId(id);

            return persona;
        }

        // POST api/<PersonasController>
        [HttpPost]
        public Task Post(clsPersona oPersona)
        {
            return clsCreatePersona.createPersona(oPersona);
        }

        // PUT api/<PersonasController>/5
        [HttpPut("{id}")]
        public Task Put(clsPersona oPersona)
        {
            return clsEditPersona.editPersonaDAL(oPersona.Id, oPersona);
        }

        // DELETE api/<PersonasController>/5
        [HttpDelete("{id}")]
        public Task Delete(int id)
        {
            return HandlerPersonaBL.deletePersonaBL(id);
        }
    }
}
