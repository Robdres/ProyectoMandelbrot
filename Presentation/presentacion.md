---
title:
- Conjuntos de Julia
author:
- Roberto Alvarado 
theme:
- Copenhagen
colortheme:
- beaver
aspectratio:
- 169
---
# Que son los conjuntos de Julia?
Los conjuntos de Julia, así llamados por el matemático Gaston Julia, son una familia de conjuntos fractales que se obtienen al estudiar el comportamiento de los números complejos al ser iterados por una función holomorfa.

\begin{center}
$z_{n+1}=z_{n}^2 +C_{o}$\\
$z_{n+1}=z_{n}^3 +C_{o}$\\
$z_{n+1}=e^{z} +C_{o}$\\
\end{center}

# Cuando divergen?
Se puede demostrar que si 
$\mid z_{n} \mid >2$
entonces la sucesión diverge y el punto z no pertenece al conjunto de Julia. Por lo tanto, basta encontrar un solo término de la sucesión que verifique 
$\mid z_{n} \mid >2$
para tener la certeza de que la iteracion no está en el conjunto

# Mandelbrot 
EL conjunto de Mandelbrot fue un conjunto investigado computacionalmente por primera vez por Benoit Mandelbrot, esta a la vez muy relacionado con un conjunto de julia que se relaciona con la funcion y el valor inicial
\begin{center}
$ z_{n+1}=z_{n}^2 +C_{o} $\\
$ z_{o}= 0 \in \mathbb C $
\end{center}

# Mandelbrot Set
::: columns
:::: column
![MandelbrotSet](2.png){height=256px}
::::
:::: column
![$z_{n}^{3}+C_{o}: z_{o}= 0 \in \mathbb C$](3.png){height=256px}
::::
:::

# Julia Sets
::: columns
:::: column
![$z_{n}^{2}-.599-0.411i$](1.png){height=200px}
::::
:::
# Ejemplos del programa
::: columns

:::: column
![$z_{n}^{3}-.599-0.411i$](5.png){height=200px}
::::
:::
# Limitaciones del programa
::: columns
:::: column 
![$e^{z}-0.6-0.65i$](6.png)
::::
:::
