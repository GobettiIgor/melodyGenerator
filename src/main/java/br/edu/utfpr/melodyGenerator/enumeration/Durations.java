package br.edu.utfpr.melodyGenerator.enumeration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Durations {
    w(1),
    h(1f/2),
    q(1f/4);/*,
    i(1f/8),
    s(1f/16),
    t(1f/32),
    x(1f/64),
    o(1f/128);*/

    public final float duration;
}
