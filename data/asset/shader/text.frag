#version 410 core
out vec4 FragColor;
uniform sampler2D font;

in vec4 oColor;
in vec2 oUV;

void main()
{
    FragColor = texture(font, oUV) * oColor;
}