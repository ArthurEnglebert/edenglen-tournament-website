<template>
    <div class="block columns small-12">
        <form action="#" v-on:submit="sendForm">
            <div class="row align-middle medium-unstack">
                <div class="columns shrink">
                    <b>Je m'inscris pour aider :</b>
                </div>
                <div class="columns">
                    <label for="lastname">
                        Nom
                        <input type="text" v-model="lastname" required>
                    </label>
                </div>

                <div class="columns">
                    <label for="firstname">
                        Prénom
                        <input type="text" v-model="firstname" required>
                    </label>
                </div>

                <div class="columns">
                    <label for="phone">
                        Téléphone
                        <input type="text" v-model="phone" required>
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="columns shrink">
                    <div class="switch small">
                        <input class="switch-input" id="decoration" type="checkbox" v-model="decoration">
                        <label class="switch-paddle" for="decoration">
                            <span class="show-for-sr">Décoration</span>
                        </label>
                    </div>
                </div>

                <div class="columns decoration">
                    Je viens aider le 14 septembre à la décoration de la tente et la mise en place des tables de
                    <input type="number" v-model="decoration_start" :required="decoration" :disabled="!decoration"> H à <input type="number" v-model="decoration_end" :required="decoration" :disabled="!decoration"> H.
                </div>
            </div>

            <div class="row">
                <div class="columns shrink">
                    <div class="switch small">
                        <input class="switch-input" id="salade" type="checkbox" v-model="salade">
                        <label class="switch-paddle" for="salade">
                            <span class="show-for-sr">Salade</span>
                        </label>
                    </div>
                </div>

                <div class="columns">
                    Je peux faire une salade pour 10 personnes.
                </div>
            </div>

            <div class="row">
                <div class="columns shrink">
                    <div class="switch small">
                        <input class="switch-input" id="ranger" type="checkbox" v-model="ranger">
                        <label class="switch-paddle" for="ranger">
                            <span class="show-for-sr">Ranger</span>
                        </label>
                    </div>
                </div>

                <div class="columns decoration">
                    Je viens aider à ranger le 16 septembre de
                    <input type="number" v-model="ranger_start" :required="ranger" :disabled="!ranger"> H à <input type="number" v-model="ranger_end" :required="ranger" :disabled="!ranger"> H.
                </div>
            </div>

            <div class="row">
                <div class="columns decoration" style="margin-left: 30%">
                    Nous serons <input type="number" v-model="people" :required="ranger" :disabled="!ranger"> personnes.
                </div>
            </div>

            <button type="submit" class="button button-primary button-envoyer">Envoyer</button>
        </form>
    </div>
</template>

    <script>
        import { EventBus } from '../EventBus';
        import _ from 'lodash';
        import {HTTP} from '../http';

        export default {
            props: [],
            data: function () {
                return {
                    firstname: null,
                    lastname: null,
                    phone: null,
                    decoration: false,
                    salade: false,
                    decoration_start: null,
                    decoration_end: null,
                    ranger: false,
                    ranger_start: null,
                    ranger_end: null,
                    people: null,
                }
            },

            mounted() {

            },
            created() {

            },

            methods: {

                sendForm(e) {
                    e.preventDefault();

                    HTTP.post(window.POST_REGISTER, {

                    })
                        .then((response) => {
                            if (response.body.success) {
                                console.log('success');
                            }
                        })
                        .catch(e => {
                            this.error = true;
                        });
                }
            }
        }
</script>