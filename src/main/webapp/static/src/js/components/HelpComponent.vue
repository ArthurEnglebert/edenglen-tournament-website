<template>
    <div class="block columns small-12">
        <form action="#" v-on:submit="sendForm">
            <div class="row align-middle medium-unstack">
                <div class="columns shrink">
                    <b>Je m'inscris pour aider :</b>
                </div>
                <div class="columns">
                    <label :for="name">
                        Nom
                        <input type="text" v-model="name" required>
                    </label>
                </div>

                <div class="columns">
                    <label :for="firstName">
                        Prénom
                        <input type="text" v-model="firstName" required>
                    </label>
                </div>

                <div class="columns">
                    <label :for="phone">
                        Téléphone
                        <input type="text" v-model="phone" required>
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="columns shrink">
                    <div class="switch small">
                        <input class="switch-input" id="isComingToDecorate" type="checkbox" v-model="isComingToDecorate">
                        <label class="switch-paddle" for="isComingToDecorate">
                            <span class="show-for-sr">Décoration</span>
                        </label>
                    </div>
                </div>

                <div class="columns decoration">
                    Je viens aider le 14 septembre à la décoration de la tente de
                    <input type="number" v-model="isComingToDecorateStart" :required="isComingToDecorate" :disabled="!isComingToDecorate"> H à <input type="number" v-model="isComingToDecorateEnd" :required="isComingToDecorate" :disabled="!isComingToDecorate"> H.
                </div>
            </div>

            <div class="row">
                <div class="columns shrink">
                    <div class="switch small">
                        <input class="switch-input" id="isComingToBuild" type="checkbox" v-model="isComingToBuild">
                        <label class="switch-paddle" for="isComingToBuild">
                            <span class="show-for-sr">Montage</span>
                        </label>
                    </div>
                </div>

                <div class="columns decoration">
                    Je viens aider le 14 septembre à la mise en place des tables de
                    <input type="number" v-model="isComingToBuildStart" :required="isComingToBuild" :disabled="!isComingToBuild"> H à <input type="number" v-model="isComingToBuildStart" :required="isComingToBuild" :disabled="!isComingToBuild"> H.
                </div>
            </div>

            <div class="row">
                <div class="columns shrink">
                    <div class="switch small">
                        <input class="switch-input" id="isBringingFood" type="checkbox" v-model="isBringingFood">
                        <label class="switch-paddle" for="isBringingFood">
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
                        <input class="switch-input" id="isComingToUnBuild" type="checkbox" v-model="isComingToUnBuild">
                        <label class="switch-paddle" for="isComingToUnBuild">
                            <span class="show-for-sr">Démontage</span>
                        </label>
                    </div>
                </div>

                <div class="columns decoration">
                    Je viens aider à démonter le 16 septembre de
                    <input type="number" v-model="isComingToUnBuildStart" :required="isComingToUnBuild" :disabled="!isComingToUnBuild"> H à <input type="number" v-model="isComingToUnBuildEnd" :required="isComingToUnBuild" :disabled="!isComingToUnBuild"> H.
                </div>
            </div>

            <div class="row">
                <div class="columns decoration" style="margin-left: 30%">
                    Nous serons <input type="number" v-model="numberComing" :required="name" :disabled="!name"> personnes.
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
                    firstName: null,
                    name: null,
                    phone: null,
                    isBringingFood: false,
                    isComingToBuild: false,
                    isComingToBuildStart: null,
                    isComingToBuildEnd: null,
                    isComingToDecorate: false,
                    isComingToDecorateStart: null,
                    isComingToDecorateEnd: null,
                    isComingToUnBuild: false,
                    isComingToUnBuildStart: null,
                    isComingToUnBuildEnd: null,
                    numberComing: null,
                }
            },

            mounted() {

            },
            created() {

            },

            methods: {

                sendForm(e) {
                    e.preventDefault();

                    this.$validator.validate().then(result => {
                        if (result) {
                            HTTP.post(window.POST_HELP, {
                                firstName: this.firstName,
                                name: this.name,
                                phone: this.phone,
                                isBringingFood: this.isBringingFood,
                                isComingToBuild: this.isComingToBuild,
                                comingToBuildStart: this.isComingToBuildStart,
                                comingToBuildEnd: this.isComingToBuildEnd,
                                isComingToDecorate: this.isComingToDecorate,
                                comingToDecorateStart: this.isComingToDecorateStart,
                                comingToDecorateEnd: this.isComingToDecorateEnd,
                                isComingToUnBuild: this.isComingToUnBuild,
                                comingToUnBuildStart: this.isComingToUnBuildStart,
                                comingToUnBuildEnd: this.isComingToUnBuildEnd,
                                numberComing: this.numberComing,
                            })
                                .then((response) => {
                                    alert('Invitation à aider reçue');
                                })
                                .catch(e => {
                                    this.error = true;
                                });
                        }
                    });
                }
            }
        }
</script>