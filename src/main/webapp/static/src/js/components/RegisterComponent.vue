<template>
    <div class="block columns small-12">
        <form action="#" v-on:submit="sendForm" v-if="!showMessage">
            <h2>Tennis</h2>

            <table class="show-for-large table">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Âge</th>
                        <th>sex</th>
                        <th>Niveau National</th>
                        <th>Catégorie</th>
                        <th>Email</th>
                        <th>Téléphone</th>
                        <th>Participer au diner</th>
                    </tr>
                </thead>

                <tbody>
                    <tr v-for="(tenn, index) in tennis">
                        <td>
                            <input v-validate="'required'" type="text" data-vv-as="Nom" :name="'tennis_' + index + '_name'" v-model="tenn.name" :class="{'is-invalid-input': errors.has('tennis_' + index + '_name')}">
                        </td>
                        <td>
                            <input v-validate="'required'" type="text" data-vv-as="Prénom" :name="'tennis_' + index + '_firstName'" v-model="tenn.firstName" :class="{'is-invalid-input': errors.has('tennis_' + index + '_firstName')}">
                        </td>
                        <td>
                            <input v-validate="'required'" type="number" data-vv-as="Âge" :name="'tennis_' + index + '_age'" v-model="tenn.age" :class="{'is-invalid-input': errors.has('tennis_' + index + '_age')}">
                        </td>
                        <td>
                            <div class="switch large">
                                <input class="switch-input" :id="'tennis-sex-' + index" type="checkbox" v-model="tenn.sex" >
                                <label class="switch-paddle" :for="'tennis-sex-' + index">
                                    <span class="show-for-sr">sex</span>
                                    <span class="switch-active" aria-hidden="true">F</span>
                                    <span class="switch-inactive" aria-hidden="true">H</span>
                                </label>
                            </div>
                        </td>
                        <td>
                            <select v-model="tenn.skillLevel" class="category">
                                <option value="none">----</option>
                                <option value="C30_5">C30.5</option>
                                <option value="C30_4">C30.4</option>
                                <option value="C30_3">C30.3</option>
                                <option value="C30_2">C30.2</option>
                                <option value="C30_1">C30.1</option>
                                <option value="C30">C30</option>
                                <option value="C15_5">C15.5</option>
                                <option value="C15_4">C15.4</option>
                                <option value="C15_3">C15.3</option>
                                <option value="C15_2">C15.2</option>
                                <option value="C15_1">C15.1</option>
                                <option value="C15">C15</option>
                                <option value="B_PLUS_4">B+4/6</option>
                                <option value="B_PLUS_2">B+2/6</option>
                                <option value="B0">B0</option>
                                <option value="B_MINUS_2">B-2/6</option>
                                <option value="B_MINUS_4">B-4/6</option>
                                <option value="B_MINUS_15">B-15</option>
                                <option value="B_MINUS_15_1">B-15.1</option>
                                <option value="B_MINUS_15_2">B-15.2</option>
                                <option value="B_MINUS_15_4">B-15.4</option>
                                <option value="A">A</option>
                            </select>
                        </td>
                        <td>
                            <select v-model="tenn.championshipLevel" class="category">
                                <option value="debutant">Débutant</option>
                                <option value="semi-pro">Semi pro</option>
                                <option value="pro">Pro</option>
                            </select>
                        </td>
                        <td>
                            <input  v-validate="'required|email'" type="email" v-model="tenn.email" data-vv-as="Email" :name="'tennis_' + index + '_email'" :class="{'is-invalid-input': errors.has('tennis_' + index + '_email')}">
                        </td>
                        <td>
                            <input type="text" v-model="tenn.phone" data-vv-as="Téléphone" :name="'tennis_' + index + '_phone'" :class="{'is-invalid-input': errors.has('tennis_' + index + '_phone')}">
                        </td>
                        <td>
                            <div class="switch large">
                                <input class="switch-input" :id="'tennis-dinner-' + index" type="checkbox" v-model="tenn.isDining">
                                <label class="switch-paddle" :for="'tennis-dinner-' + index">
                                    <span class="show-for-sr">Participer au diner ?</span>
                                    <span class="switch-active" aria-hidden="true">Oui</span>
                                    <span class="switch-inactive" aria-hidden="true">Non</span>
                                </label>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>

            <div class="collapse-mobile hide-for-large" >
                <div :class="{'collapse-item': true}" v-for="(tenn, index) in tennis">
                    <a href="javascript:void(0);" v-on:click="openTennis(tenn)">{{ tenn.name ? tenn.firstName + ' ' + tenn.name : 'SANS NOM' }}</a>

                    <div :class="{'panel': true, 'is-open': tenn.open || tennis.length == 1}">
                        <label>
                            Nom
                            <input v-validate="'required'" type="text" data-vv-as="Nom" :name="'tennis_' + index + '_name'" v-model="tenn.name" :class="{'is-invalid-input': errors.has('tennis_' + index + '_name')}">
                        </label>

                        <label>
                            Prénom
                            <input v-validate="'required'" type="text" data-vv-as="Prénom" :name="'tennis_' + index + '_firstName'" v-model="tenn.firstName" :class="{'is-invalid-input': errors.has('tennis_' + index + '_firstName')}">
                        </label>

                        <label>
                            Âge
                            <input v-validate="'required'" type="number" data-vv-as="Âge" :name="'tennis_' + index + '_age'" v-model="tenn.age" :class="{'is-invalid-input': errors.has('tennis_' + index + '_age')}">
                        </label>

                        <label>
                            sex
                            <div class="switch large">
                                <input class="switch-input" :id="'tennis-sex-' + index" type="checkbox" v-model="tenn.sex" >
                                <label class="switch-paddle" :for="'tennis-sex-' + index">
                                    <span class="show-for-sr">sex</span>
                                    <span class="switch-active" aria-hidden="true">F</span>
                                    <span class="switch-inactive" aria-hidden="true">H</span>
                                </label>
                            </div>
                        </label>

                        <label>
                            Niveau national
                            <select v-model="tenn.skillLevel" class="category">
                                <option value="none">----</option>
                                <option value="C30_5">C30.5</option>
                                <option value="C30_4">C30.4</option>
                                <option value="C30_3">C30.3</option>
                                <option value="C30_2">C30.2</option>
                                <option value="C30_1">C30.1</option>
                                <option value="C30">C30</option>
                                <option value="C15_5">C15.5</option>
                                <option value="C15_4">C15.4</option>
                                <option value="C15_3">C15.3</option>
                                <option value="C15_2">C15.2</option>
                                <option value="C15_1">C15.1</option>
                                <option value="C15">C15</option>
                                <option value="B_PLUS_4">B+4/6</option>
                                <option value="B_PLUS_2">B+2/6</option>
                                <option value="B0">B0</option>
                                <option value="B_MINUS_2">B-2/6</option>
                                <option value="B_MINUS_4">B-4/6</option>
                                <option value="B_MINUS_15">B-15</option>
                                <option value="B_MINUS_15_1">B-15.1</option>
                                <option value="B_MINUS_15_2">B-15.2</option>
                                <option value="B_MINUS_15_4">B-15.4</option>
                                <option value="A">A</option>
                            </select>
                        </label>

                        <label>
                            Catégorie
                            <select v-model="tenn.championshipLevel" class="category">
                                <option value="debutant">Débutant</option>
                                <option value="semi-pro">Semi pro</option>
                                <option value="pro">Pro</option>
                            </select>
                        </label>

                        <label>
                            Email
                            <input  v-validate="'required|email'" type="email" v-model="tenn.email" data-vv-as="Email" :name="'tennis_' + index + '_email'" :class="{'is-invalid-input': errors.has('tennis_' + index + '_email')}">
                        </label>

                        <label>
                            Téléphone
                            <input type="text" v-model="tenn.phone" data-vv-as="Téléphone" :name="'tennis_' + index + '_phone'" :class="{'is-invalid-input': errors.has('tennis_' + index + '_phone')}">
                        </label>

                        <label>
                            Participer au diner ?
                            <div class="switch large">
                                <input class="switch-input" :id="'tennis-dinner-' + index" type="checkbox" v-model="tenn.isDining">
                                <label class="switch-paddle" :for="'tennis-dinner-' + index">
                                    <span class="show-for-sr">Participer au diner ?</span>
                                    <span class="switch-active" aria-hidden="true">Oui</span>
                                    <span class="switch-inactive" aria-hidden="true">Non</span>
                                </label>
                            </div>
                        </label>
                    </div>
                </div>
            </div>

            <a class="button button-primary" v-on:click="addTennis">Ajouter</a>

            <hr>

            <h2>Diner uniquement</h2>

            <table class="show-for-large table">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Âge</th>
                        <th>Email</th>
                    </tr>
                </thead>

                <tbody>
                <tr v-for="(dinn, index) in diner">
                    <td>
                        <input v-validate="'required'" type="text" data-vv-as="Nom" :name="'diner_' + index + '_name'" v-model="dinn.name" :class="{'is-invalid-input': errors.has('diner_' + index + '_name')}">
                    </td>
                    <td>
                        <input v-validate="'required'" type="text" data-vv-as="Prénom" :name="'diner_' + index + '_firstName'" v-model="dinn.firstName" :class="{'is-invalid-input': errors.has('diner_' + index + '_firstName')}">
                    </td>
                    <td>
                        <input v-validate="'required'" type="number" data-vv-as="Âge" :name="'diner_' + index + '_age'" v-model="dinn.age" :class="{'is-invalid-input': errors.has('diner_' + index + '_age')}">
                    </td>
                    <td>
                        <input  v-validate="'required|email'" type="email" v-model="dinn.email" data-vv-as="Email" :name="'diner_' + index + '_email'" :class="{'is-invalid-input': errors.has('diner_' + index + '_email')}">
                    </td>
                </tr>
                </tbody>
            </table>

            <div class="collapse-mobile hide-for-large" >
                <div :class="{'collapse-item': true}" v-for="(dinn, index) in diner">
                    <a href="javascript:void(0);" v-on:click="openDiner(dinn)">{{ dinn.name ? dinn.firstName + ' ' + dinn.name : 'SANS NOM' }}</a>

                    <div :class="{'panel': true, 'is-open': dinn.open || diner.length == 1}">
                        <label>
                            Nom
                            <input v-validate="'required'" type="text" data-vv-as="Nom" :name="'diner_' + index + '_name'" v-model="dinn.name" :class="{'is-invalid-input': errors.has('diner_' + index + '_name')}">
                        </label>

                        <label>
                            Prénom
                            <input v-validate="'required'" type="text" data-vv-as="Prénom" :name="'diner_' + index + '_firstName'" v-model="dinn.firstName" :class="{'is-invalid-input': errors.has('diner_' + index + '_firstName')}">
                        </label>

                        <label>
                            Âge
                            <input v-validate="'required'" type="number" data-vv-as="Âge" :name="'diner_' + index + '_age'" v-model="dinn.age" :class="{'is-invalid-input': errors.has('diner_' + index + '_age')}">
                        </label>

                        <label>
                            Email
                            <input  v-validate="'required|email'" type="email" v-model="dinn.email" data-vv-as="Email" :name="'diner_' + index + '_email'" :class="{'is-invalid-input': errors.has('diner_' + index + '_email')}">
                        </label>
                    </div>
                </div>
            </div>

            <a class="button button-primary"v-on:click="addDinner">Ajouter</a>

            <hr>

            <div class="row">
                <div class="columns small-12 medium-6">
                    <div class="input-group">
                        <span class="input-group-label">Faire un don</span>
                        <input class="input-group-field" name="donate" type="number" v-model="donate">&nbsp;
                        <div class="input-group-euro">
                            €
                        </div>
                    </div>
                </div>
                <div class="columns small-12 medium-6">
                    <div class="total">
                        <div class="row">
                            <div class="columns">
                                <p>TOTAL</p>
                            </div>
                            <div class="columns">
                                {{ total }}&nbsp;&euro;
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <button class="button button-secondary button-envoyer" type="submit">Envoyer</button>
        </form>
        <div v-else class="result">
            <h3>INSCRIPTION REUSSIE !</h3>
            <p>
                N’OUBLIEZ PAS DE PAYER LE MONTANT TOTAL DE <b>{{ total }} €</b> SUR LE COMPTE SUIVANT : <b>BEXXXXX</b><br>
                COMMUNICATION : <b>« TOURNOI DE TENNIS + {{ donate }} € dons »</b><br><br>
                AU 15 !
            </p>
        </div>
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
                    tennis: [
                        {
                            firstName: '',
                            name: '',
                            sex: false,
                            age: '',
                            skillLevel: 'none',
                            championshipLevel: 'debutant',
                            email: '',
                            phone: '',
                            isDining: false,
                            open: false
                        }
                    ],
                    diner: [
                        {
                            firstName: '',
                            name: '',
                            email: '',
                            age: '',
                            open: false
                        }
                    ],
                    prices: {
                        tennis: {
                            sup25: 35,
                            sub25: 25
                        },
                        diner: {
                            sup25: 30,
                            sub25: 20
                        }
                    },
                    total: 0,
                    donate: 0,
                    error: false,
                    showMessage: false,
                    players: []
                }
            },

            mounted() {
                this.calculateTotal();
            },
            created() {

            },
            watch: {
                tennis: {
                    handler(val){
                        this.calculateTotal();
                    },
                    deep: true,
                },
                diner: {
                    handler(val){
                        this.calculateTotal();
                    },
                    deep: true,
                },
                donate() {
                    this.calculateTotal();
                }
            },
            methods: {
                addTennis(e) {
                    e.preventDefault();

                    this.tennis.push({
                        firstName: '',
                        name: '',
                        sex: '',
                        age: '',
                        skillLevel: 'none',
                        championshipLevel: 'debutant',
                        email: '',
                        telephone: '',
                        diner: false,
                        open: false,
                    });

                    this.openTennis(this.tennis[this.tennis.length - 1]);
                },
                addDinner(e) {
                    e.preventDefault();

                    this.diner.push({
                        firstName: '',
                        name: '',
                        age: '',
                        email: '',
                        open: false
                    });

                    this.openDiner(this.diner[this.diner.length - 1]);
                },
                calculateTotal() {
                    let total = 0;
                    let tennisSup25 = this.prices.tennis.sup25;
                    let tennisSub25 = this.prices.tennis.sub25;
                    let dinnerSup25 = this.prices.diner.sup25;
                    let dinnerSub25 = this.prices.diner.sub25;

                    this.tennis.forEach((tenn) => {
                        if (tenn.name !== '') {
                            if (tenn.age > 25) {
                                total += tennisSup25;
                            } else {
                                total += tennisSub25;
                            }
                        }
                    });

                    this.diner.forEach((dinn) => {
                        if (dinn.name !== '') {
                            if (dinn.age > 25) {
                                total += dinnerSup25;
                            } else {
                                total += dinnerSub25;
                            }
                        }
                    });

                    let donate = parseFloat(this.donate);

                    this.total = total + (!_.isNaN(donate) ? donate : 0);
                    this.total = _.isNaN(this.total) ? 0 : this.total;
                },
                openTennis(tenn) {
                    this.tennis.forEach((tenn) => {
                        tenn.open = false;
                    });

                    tenn.open = !tenn.open;
                },
                openDiner(dinn) {
                    this.diner.forEach((dinn) => {
                        dinn.open = false;
                    });

                    dinn.open = !dinn.open;
                },
                sendForm(e) {
                    e.preventDefault();

                    this.$validator.validate().then(result => {
                        if (result) {
                            this.players = [];

                            this.tennis.forEach((item) => {
                                this.players.push({
                                    firstName: item.firstName,
                                    name: item.name,
                                    sex: item.sex == true ? 'FEMALE' : 'MALE',
                                    age: item.age,
                                    skillLevel: item.skillLevel,
                                    championshipLevel: item.championshipLevel,
                                    email: item.email,
                                    phone: item.phone,
                                    isDining: item.isDining == true ? 1 : 0,
                                })
                            });


                            HTTP.post(window.POST_REGISTER, {
                                players: this.players,
                                eaters: this.diner,
                            donation: this.donate
                            })
                            .then((response) => {
                              this.showMessage = true;
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