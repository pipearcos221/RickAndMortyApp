# 📱 Rick and Morty API Challenge - Arkano

Este repositorio contiene la solución al reto técnico para la posición de Android Developer, diseñado para evaluar el consumo de APIs públicas y el manejo eficiente de la interfaz de usuario en la plataforma Android.

---

## 🛠️ Decisiones técnicas tomadas

* 🏗️ **Arquitectura:** Se implementó el patrón **MVVM** estructurado mediante paquetes (*Domain, Data, Presentation*) bajo los principios de **Clean Architecture**. Se priorizó la claridad sobre la cantidad de capas, optando por instanciar las dependencias mediante un `ViewModelFactory` manual para garantizar un entregable funcional, seguro y libre de errores de configuración en el tiempo límite.
* 🎨 **Interfaz de Usuario:** La UI se construyó en su totalidad utilizando **Jetpack Compose**, permitiendo un renderizado declarativo, moderno y fluido.
* 🔄 **Manejo de Estado:** Se diseñó un modelo de estado sólido utilizando `StateFlow`. La interfaz reacciona de forma explícita a los escenarios de **Loading**, **Success** y **Error** (este último incluyendo un botón de reintento funcional).
* 🖼️ **Carga de Imágenes:** Se integró la librería **Coil** para la carga asíncrona de imágenes en la lista. Se configuraron *placeholders* de carga y recursos visuales de error, aprovechando el sistema de caché nativo para evitar recargas innecesarias al hacer scroll.
* 🧪 **Calidad y Testing:** Se incluyeron pruebas unitarias para la capa de presentación (`ViewModel`) y la capa de datos (`Repository`) utilizando **JUnit**, **MockK** y **Coroutines Test**, validando las transiciones de estado de la UI y el correcto mapeo de datos.

---

## ⏳ Qué quedó fuera por falta de tiempo

* 🎭 Cobertura de pruebas de UI e instrumentadas.
* 🎨 Detalles avanzados de diseño de UI / animaciones de transición.

---

## 🔮 Qué se mejoraría con más tiempo

* ⚙️ **Casos de Uso (Use Cases):** Implementación explícita de casos de uso o interactores en la capa de dominio para encapsular de forma aislada e independiente la lógica de negocio, abstrayendo por completo al `ViewModel` de las reglas de aplicación y optimizando la mantenibilidad del código.
* 💉 **Inyección de Dependencias (Hilt):** Integración formal de Dagger Hilt para automatizar la provisión de dependencias, reduciendo el acoplamiento y facilitando la escalabilidad a largo plazo.
* 📄 **Paginación (Paging 3):** Implementación de la librería Paging 3 para administrar la carga incremental de personajes desde la API, optimizando el consumo de memoria y red con conjuntos de datos extensos.
* 💾 **Persistencia Local (Room):** Incorporación de una base de datos local para almacenar los personajes de forma segura, funcionando como *Single Source of Truth* y permitiendo soporte offline completo.
* 📦 **Modularización:** División física del proyecto mediante módulos de Gradle independientes por funcionalidad o capa, mejorando los tiempos de compilación aislada.

---

## 🤖 Uso de IA

* Se empleó asistencia de Inteligencia Artificial (LLMs) bajo la modalidad de **pair programming** como herramienta de apoyo para agilizar la generación de código *boilerplate* (modelos de datos de Retrofit, esqueletos iniciales de componentes en Compose y configuración base para los *mocks* de testing). Todas las decisiones arquitectónicas finales, la gestión del estado reactivo, el control del flujo de datos y las revisiones de lógica se mantuvieron bajo estricta supervisión y desarrollo manual.
