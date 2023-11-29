using Ejercicio3.Models.Entities;

namespace Ejercicio1.Models.ViewModel
{
    public class PersonaVM
    {
            public clsPersona persona { get; set; }

            public PersonaVM()
            {

            }
            public PersonaVM(clsPersona Persona)
            {
                persona = Persona;
            }
     }
}
