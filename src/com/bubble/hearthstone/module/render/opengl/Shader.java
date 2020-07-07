package com.bubble.hearthstone.module.render.opengl;

import java.util.logging.Logger;

import com.bubble.hearthstone.util.file.FileLoader;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class Shader {
    private final int program;

    public Shader(String path) {
        program = GL20.glCreateProgram();

        // vertex shader
        final int vertexShader = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
        GL20.glShaderSource(vertexShader, load(path + ".vert"));
        GL20.glCompileShader(vertexShader);
        
        int[] status = new int[1];
        GL20.glGetShaderiv(vertexShader, GL20.GL_COMPILE_STATUS, status);
        if (status[0] == GL11.GL_FALSE) {
            final String msg = GL20.glGetShaderInfoLog(vertexShader);
            Logger.getLogger(this.getClass().getName()).info(msg);
        }

        GL20.glAttachShader(program, vertexShader);

        // fragment shader
        final int fragShader = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
        GL20.glShaderSource(fragShader, load(path + ".frag"));
        GL20.glCompileShader(fragShader);

        GL20.glGetShaderiv(fragShader, GL20.GL_COMPILE_STATUS, status);
        if (status[0] == GL11.GL_FALSE) {
            final String msg = GL20.glGetShaderInfoLog(fragShader);
            Logger.getLogger(this.getClass().getName()).info(msg);
        }

        GL20.glAttachShader(program, fragShader);

        // link program ^v^
        GL20.glLinkProgram(program);
        
        GL20.glGetProgramiv(program, GL20.GL_LINK_STATUS, status);
        if (status[0] == GL11.GL_FALSE) {
            final String msg = GL20.glGetProgramInfoLog(program);
            Logger.getLogger(this.getClass().getName()).info(msg);
        }

        GL20.glDeleteShader(vertexShader);
        GL20.glDeleteShader(fragShader);
    }

    public void destroy() {
        GL20.glDeleteProgram(program);
    }

    public void bind() {
        GL20.glUseProgram(program);
    }

    public void unbind() {
        GL20.glUseProgram(0);
    }

    private String load(String path) {
        return new FileLoader(path).load();
    } 
}