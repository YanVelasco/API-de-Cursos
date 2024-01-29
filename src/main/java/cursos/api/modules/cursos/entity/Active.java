package cursos.api.modules.cursos.entity;

public enum Active {
    ATIVO,
    INATIVO;

    public static Active fromString(String value) {
        for (Active active : Active.values()) {
            if (active.name().equalsIgnoreCase(value)) {
                return active;
            }
        }
        throw new IllegalArgumentException("No constant with the specified name " + value);
    }
}
