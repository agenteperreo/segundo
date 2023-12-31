﻿namespace Ejercicio1_T10.Models.Entidades
{
    public class clsPersona
    {
        #region Propiedades
        public int Id { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string Telefono { get; set; }
        public string Direccion {  get; set; }
        public string Foto { get; set; }
        public DateTime FechaNac {  get; set; }
        public int IdDep {  get; set; }
        #endregion

        #region Constructores
        public clsPersona() { }

        public clsPersona(int id, string nombre, string apellidos, string telefono, int idDep)
        {
            Id = id;
            Nombre = nombre;
            Apellidos = apellidos;
            Telefono = telefono;
            IdDep = idDep;
        }

        public clsPersona(int id, string nombre, string apellidos, string telefono, string direccion, string foto, DateTime fechaNac)
        {
            Id = id;
            Nombre = nombre;
            Apellidos = apellidos;
            Telefono = telefono;
            Direccion = direccion;
            Foto = foto;
            FechaNac = fechaNac;
        }
        #endregion

    }
}