#version 410 core
layout (location = 0) in vec3 iPos;
layout (location = 1) in vec4 iColor;
layout (location = 2) in vec2 iUV;

out vec4 oColor;
out vec2 oUV;

void main()
{
    oColor = iColor;
    oUV = iUV;
    gl_Position = vec4(iPos, 1.0);
}