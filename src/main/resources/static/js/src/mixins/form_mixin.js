export default {
    data() {
        return {
            errors: {}
        }
    },
    methods: {
        clearFieldError(field) {
            delete this.errors[field];
            delete this.errors["globalError"];
            this.errors = Object.assign({}, this.errors);
            if (this.vErrors) {
                this.vErrors.remove(field);
            }
        },
        createFormData(object, form, namespace) {
            const formData = form || new FormData();
            for (let property in object) {
                if (!object.hasOwnProperty(property) || !object[property]) {
                    continue;
                }
                const formKey = namespace ? `${namespace}[${property}]` : property;
                if (object[property] instanceof Date) {
                    formData.append(formKey, object[property].toISOString());
                } else if (typeof object[property] === 'object' && !(object[property] instanceof File)) {
                    createFormData(object[property], formData, formKey);
                } else {
                    formData.append(formKey, object[property]);
                }
            }
            return formData;
        }
    }
}