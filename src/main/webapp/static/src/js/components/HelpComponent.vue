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
                        <input class="switch-input" id="isComingToBuild" type="checkbox" v-model="isComingToBuildAndDecorate">
                        <label class="switch-paddle" for="isComingToBuild">
                            <span class="show-for-sr">Décoration</span>
                        </label>
                    </div>
                </div>

                <div class="columns decoration">
                    Je viens aider le 14 septembre à la décoration de la tente et la mise en place des tables de
                    <input type="number" v-model="isComingToBuildAndDecorateStart" :required="isComingToBuildAndDecorate" :disabled="!isComingToBuildAndDecorate"> H à <input type="number" v-model="isComingToBuildAndDecorateEnd" :required="isComingToBuildAndDecorate" :disabled="!isComingToBuildAndDecorate"> H.
                </div>
            </div>

            <div class="row">
                <div class="columns shrink">
                    <div class="switch small">
                        <input class="switch-input" id="isBringingFood" type="checkbox" v-model="isBringingFood">
                        <label class="switch-paddle" for="isBringingFood">
                            <span class="show-for-sr">isBringingFood</span>
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
                            <span class="show-for-sr">isComingToUnBuild</span>
                        </label>
                    </div>
                </div>

                <div class="columns decoration">
                    Je viens aider à démonter le 16 septembre de
                    <input type="number" v-model="isComingToUnBuildStart" :required="isComingToUnBuild" :disabled="!isComingToUnBuild"> H à <input type="number" v-model="isComingToUnBuildEnd" :required="isComingToUnBuild" :disabled="!isComingToUnBuild"> H.
                </div>
            </div>

            <div class="row">
                <div class="columns isComingToBuild" style="margin-left: 30%">
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
                    isComingToBuildAndDecorate: false,
                    isComingToBuildAndDecorateStart: null,
                    isComingToBuildAndDecorateEnd: null,
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
                                isComingToBuildAndDecorate: this.isComingToBuildAndDecorate,
                                comingToBuildAndDecorateStart: this.isComingToBuildAndDecorateStart,
                                comingToBuildAndDecorateEnd: this.isComingToBuildAndDecorateEnd,
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