export default {
    data: () => {
        return {
            translations: window.trans
        }
    },
    methods: {
        trans(key) {
            if (this.translations[key] !== undefined) {
                return this.translations[key];
            } else {
                console.log(key);
                return '!MT! ' + key;
            }
        }
    }
}