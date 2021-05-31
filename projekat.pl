%excavation
name(excavation).
likelihood-of-attack(excavation,high).
typical-severity(excavation,medium).
prerequisites(excavation,interacting-with-the-system).
mitigations(excavation,[response-output-for-functional-use,remove-sensitive-information]).
weaknesses(excavation,[exposure-of-sensitive-information-to-an-unauthorized-actor,sensitive-information-not-protected-during-debug]).

%collect-data-from-common-resource-locations
name(collect-data-from-common-resource-locations).
typical-severity(collect-data-from-common-resource-locations,medium).
prerequisites(collect-data-from-common-resource-locations,files-located-at-a-specific-location).
weaknesses(collect-data-from-common-resource-locations,[files-or-directories-accessible-to-external-parties, improper-zeroization-of-hardware-register, exposure-of-sensitive-system-information-due-to-uncleared-debug-information, improper-scrubbing-of-sensitive-data-from-decommissioned-device, sensitive-information-uncleared-before-debug/power-state-transition, improper-management-of-sensitive-trace-data, sensitive-information-accessible-by-physical-probing-of-jtag-interface, remanent-data-readable-after-memory-erase]).

%query-system-for-information
name(query-system-for-information).
likelihood-of-attack(query-system-for-information, high).
typical-severity(query-system-for-information, low).
execution-flow(query-system-for-information, [explore-determine-user-controllable-parameters-of-the-application, exploit-inject-each-parameter-with-content-that-causes-an-error-condition-to-manifest, exploit-modify-the-content-of-each-parameter, exploit-repeat-above-steps]).
prerequisites(query-system-for-information, authorized-access-not-strictly-required).
mitigations(query-system-for-information, [a-'code-book'-for-error-messages, wrapping-application-functionality-in-an-output-encoding-scheme]).
weaknesses(query-system-for-information, error-message-containing-sensitive-information).

%directory-indexing
name(directory-indexing).
likelihood-of-attack(directory-indexing, high).
typical-severity(directory-indexing, medium).
execution-flow(directory-indexing, [explore-directory-discovery, experiment-iteratively-explore-directory/file-structures, exploit-read-unpublic-directories-or-files]).
prerequisites(directory-indexing, [misconfigured-target, adversary-can-control-the-path, administrator-failed-to-properly-configure-an-ACL, server-version-not-prevent-directory-listing-attacks-from-working]).
mitigations(directory-indexing, [blank-index-html-prevent-directory-listings-from-displaying, preventing-with-htaccess-in-apache-web-server, suppressing-error-messages]).
weaknesses(directory-indexing, [improper-protection-of-alternate-path, direct-request, authentication-bypass-using-an-alternate-path, improper-authorization, incorrect-permission-assignment-for-critical-resource, incorrect-default-permissions, protection-mechanism-failure, failure-to-restrict-url-access]).

%fuzzing-for-application-mapping
name(fuzzing-for-application-mapping).
likelihood-of-attack(fuzzing-for-application-mapping, high).
typical-severity(fuzzing-for-application-mapping, low).
execution-flow(fuzzing-for-application-mapping, [explore-probing, experiment-modify-parameters-to-get-the-desired-information-from-error-messages]).
prerequisites(fuzzing-for-application-mapping, target-application-fail-to-sanitize-incoming-messages-before-processing).
mitigations(fuzzing-for-application-mapping, [a-code-book-for-error-messages, wrapping-application-functionality-in-an-output-encoding-scheme]).
weaknesses(fuzzing-for-application-mapping, [error-message-containing-sensitive-information, insertion-of-sensitive-information-into-log-file]).

%fuzzing-for-garnering-other-adjacent-user/sensitive-data
name(fuzzing-for-garnering-other-adjacent-user/sensitive-data).
typical-severity(fuzzing-for-garnering-other-adjacent-user/sensitive-data, medium).
prerequisites(fuzzing-for-garnering-other-adjacent-user/sensitive-data, [server-assumes-that-the-queries-it-receives-follow-specific-templates,server-processes-queries-that-it-receives-without-checking-queries]).
weaknesses(fuzzing-for-garnering-other-adjacent-user/sensitive-data, improper-input-validation).

%cross-domain-search-timing
name(cross-domain-search-timing).
typical-severity(cross-domain-search-timing, medium).
prerequisites(cross-domain-search-timing, [ability-to-issue-get/post-requests-cross-domain, java-scripts-enabled-in-the-victims-browser, the-victim-has-an-active-session-with-place-of-attack, not-protect-search-functionality-with-cross-site-request-forgery-protection]).
mitigations(cross-domain-search-timing, [protect-sensitive-functionality-with-cross-site-request-forgery-protection, browsers-security-model-does-not-leak-timing-information-for-cross-domain-requests]).
weaknesses(cross-domain-search-timing, [covert-timing-channel, cross-site-request-forgery, observable-timing-discrepancy]).

%wsdl-scanning
name(wsdl-scanning).
likelihood-of-attack(wsdl-scanning, high).
typical-severity(wsdl-scanning, high).
execution-flow(wsdl-scanning, [explore-scaning-for-wsdl-documents, experiment-analyzing-the-wsdl-files-and-try-to-find-potential-weaknesses, exploit-crafting-malicious-content-to-be-sent-to-the-system]).
prerequisites(wsdl-scanning, [a-client-program-connecting-to-a-web-service-can-read-the-wsdl-to-determine-what-functions-are-available-on-the-server, exposing-vulnerable-functions-within-its-wsdl-interface]).
mitigations(wsdl-scanning, [protect-wsdl-file-or-provide-limited-access-to-it, ensure-the-wsdl-does-not-expose-functions-and-api-s-that-were-not-intended-to-be-exposed, pay-attention-to-the-function-naming-convention, validate-the-received-messages-against-the-wsdl-schema]).
weaknesses(wsdl-scanning, insertion-of-sensitive-information-into-externally-accessible-file-or-directory).

%pull-data-from-system-resources
name(pull-data-from-system-resources).
weaknesses(pull-data-from-system-resources, [improper-zeroization-of-hardware-register, sensitive-information-not-protected-during-debug, exposure-of-sensitive-system-information-due-to-uncleared-debug-information, improper-scrubbing-of-sensitive-data-from-decommissioned-device, sensitive-information-uncleared-before-debug/power-state-transition, missing-protection-against-hardware-reverse-engineering-using-integrated-circuit-imaging-techniques, improper-management-of-sensitive-trace-data, sensitive-information-accessible-by-physical-robing-of-jtag-interface, remanent-data-readable-after-memory-erase]).

%probe-application-memory
name(probe-application-memory).
likelihood-of-attack(probe-application-memory, low).
typical-severity(probe-application-memory, medium).
prerequisites(probe-application-memory, [cloud-provider-must-not-delete-part-of-the-sensitive-data-for-which-they-are-responsible, adversary-must-have-the-ability-to-interact-with-the-system]).
mitigations(probe-application-memory, [cloud-providers-should-completely-delete-data-to-render-it-irrecoverable, deletion-of-data-should-be-completed-promptly-when-requested]).
weaknesses(probe-application-memory, [improper-access-control, improper-scrubbing-of-sensitive-data-from-decommissioned-device, sensitive-information-uncleared-before-debug/power-state-transition]).

%reverse-engineering
name(reverse-engineering).
likelihood-of-attack(reverse-engineering, low).
typical-severity(reverse-engineering, low).
prerequisites(reverse-engineering, access-to-targeted-system-resources-and-information).
mitigations(reverse-engineering, employ-code-obfuscation-techniques-to-prevent-the-adversary-from-reverse-engineering-the-targeted-entity).

%white-box-reverse-engineering
name(white-box-reverse-engineering).
typical-severity(white-box-reverse-engineering, medium).
prerequisites(white-box-reverse-engineering, direct-access-to-the-object-or-software).
weaknesses(white-box-reverse-engineering, [improper-management-of-sensitive-trace-data, sensitive-information-accessible-by-physical-probing-of-jtag-interface]).

%lifting-sensitive-data-embedded-in-cache
name(lifting-sensitive-data-embedded-in-cache).
typical-severity(lifting-sensitive-data-embedded-in-cache, medium).
prerequisites(lifting-sensitive-data-embedded-in-cache, [target-application-must-store-sensitive-information-in-a-cache, cache-must-be-inadequately-protected-against-attacker-access]).
weaknesses(lifting-sensitive-data-embedded-in-cache, [use-of-cache-containing-sensitive-information, missing-encryption-of-sensitive-data, improper-zeroization-of-hardware-register, exposure-of-sensitive-system-information-due-to-uncleared-debug-information]).


%Retrieve Embedded Sensitive Data
name(retrieve-embedded-sensitive-data).
likelihood-of-attack(retrieve-embedded-sensitive-data,high).
typical-severity(retrieve-embedded-sensitive-data,very-high).
prerequisites(retrieve-embedded-sensitive-data, [unprotected-information,presented-valuable-date]).
weaknesses(retrieve-embedded-sensitive-data, [sensitive-information-in-resource-not-removed-before-reuse,missing-encryption-of-sensitive-data,use-of-web-browser-cache-containing-sensitive-information,cleartext-storage-of-sensitive-information,cleartext-storage-in-the-registry,cleartext-storage-of-sensitive-information-in-a-cookie,cleartext-storage-of-sensitive-information-in-executable,improper-zeroization-of-hardware-register,exposure-of-sensitive-system-information-due-to-uncleared-debug-information,improper-scrubbing-of-sensitive-data-from-decommissioned-device,sensitive-information-uncleared-before-debug/power-state-transition,missing-protection-against-hardware-reverse-engineering-using-integrated-circuit-imaging-techniquesn,remanent-data-readable-after-memory-erase]).
execution-flow(retrieve-embedded-sensitive-data,[explore-identify-target,experiment-aply-mining-techniques]).



%Black Box Reverse Engineering
name(black-box-reverse-engineering).
typical-severity(black-box-reverse-engineering,low).
weaknesses(black-box-reverse-engineering, observable-discrepancy).


%Analysis-of-Packet-Timing-and-Sizes
name(analysis-of-packet-timing-and-sizes).
typical-severity(analysis-of-packet-timing-and-sizes,low).
weaknesses(analysis-of-packet-timing-and-sizes, [insertion-of-sensitive-information-into-sent-data,poor-data-encryption]).
prerequisites(analysis-of-packet-timing-and-sizes, use-of-untrusted-communication-paths).
mitigations(analysis-of-packet-timing-and-sizes, distort-packet-sizes-and-timing-at-vpn-layerto-reduce-information-leakage-via-timing).


%Electromagnetic Side-Channel Attack
name(electromagnetic-side-channel-attack).
typical-severity(electromagnetic-side-channel-attack,low).
weaknesses(electromagnetic-side-channel-attack, insertion-of-sensitive-information-into-sent-data).
prerequisites(electromagnetic-side-channel-attack, proximal-access-to-the-device).
mitigations(electromagnetic-side-channel-attack, [side-channel-resistant-implementations-of-all-crypto-algorithms,strong-physical-security-of-all-devices-with-secret-key-information]).


%Compromising Emanations Attack
name(compromising-emanations-attack).
typical-severity(compromising-emanations-attack,low).
weaknesses(compromising-emanations-attack, insertion-of-sensitive-information-into-sent-data).
prerequisites(compromising-emanations-attack, proximal-access-to-the-device).


%Protocol Analysis
name(protocol-analysis).
likelihood-of-attack(protocol-analysis,low).
typical-severity(protocol-analysis,low).
weaknesses(protocol-analysis, inadequate-encryption-strength).
prerequisites(protocol-analysis,[access-to-a-binary-executable,ability-to-observe-and-interact-with-a-communication-channel-between-communicating-processes]).


%Cryptanalysis
name(cryptanalysis).
likelihood-of-attack(cryptanalysis,low).
typical-severity(cryptanalysis,very-high).
weaknesses(cryptanalysis,[use-of-a-broken-or-risky-cryptographic-algorithm,use-of-a-risky-cryptographic-primitive,use-of-predictable-algorithm-in-random-number-generator,cryptographic-operations-are-run-before-supporting-units-are-ready,explore-weakness-in-the-cryptographic-algorithm,explore-weakness-in-how-cryptographic-algorithm-was-applied-to-a-particular-chunk-of-plaintext,exploit-attacker-leverages-the-discovered-weakness-to-decrypt]).
prerequisites(cryptanalysis,[target-software-utilizes-some-sort-of-cryptographic-algorithm,weaknesses-exists-either-in-the-cryptographic-algorithm,attacker-has-access-to-the-ciphertext,attacker-must-know-encryptoin-algorithm]).
mitigations(cryptanalysis,[use-proven-cryptographic-algorithms-with-recommended-key-sizes,ensure-that-the-algorithms-are-used-properly]).


%Authentication Abuse
name(authentication-abuse).
typical-severity(authentication-abuse, medium).
weaknesses(authentication-abuse, [improper-authentication,  improper-access-to-sensitive-information-using-debug-and-test-interfaces]).
prerequisites(authentication-abuse, an-authentication-mechanism-or-subsystem-implementing-some-form-of-authentication).

%Privilege Abuse
name(privilege-abuse).
likelihood-of-attack(privilege-abuse, high).
typical-severity(privilege-abuse, very-high).
weaknesses(privilege-abuse, [improper-privilege-management,  incorrect-permission-assignment-for-critical-resource,missing-security-checks-in-fabric-bridge]).
prerequisites(privilege-abuse, [sensitive-information-remains-accessible-to-less-trusted-users,  the-adversary-must-have-access-to-the-target]).
mitigations(privilege-abuse,  configure-account-privileges).

%Accessing Functionality Not Properly Constrained By ACLs
name(accessing-functionality-not-properly-constrained-by-acls).
likelihood-of-attack(accessing-functionality-not-properly-constrained-by-acls, high).
typical-severity(accessing-functionality-not-properly-constrained-by-acls, high).
weaknesses(accessing-functionality-not-properly-constrained-by-acls, [incorrect-default-permissions,improper-authorization,unrestricted-upload-of-file-with-dangerous-type,protection-mechanism-failure,failure-to-restrict-url-access,incorrect-permission-assignment-for-critical-resource,exposed-chip-debug-and-test-interface,insufficient-granularity-of-access-control,improper-restriction-of-write-once-bit-fields,improper-access-to-sensitive-information-using-debug-and-test-interfaces,cpu-hardware-not-configured-to-support-exclusivity-of-write-and-execute-operations,improper-access-control-applied-to-mirrored-or-aliased-memory-regions,register-interface-allows-software-access-to-sensitive-data-or-security-settings,policy-privileges-are-not-assigned-consistently-between-control-and-data-agents,mutable-attestation-or-measurement-reporting-data,improper-translation-of-security-attributes-by-fabric-bridge,missing-protection-for-mirrored-regions-in-on-chip-fabric-firewall,hardware-allows-activation-of-test-or-debug-logic-at-runtime,missing-write-protection-for-parametric-data-values,improper-setting-of-bus-controlling-capability-in-fabric-end-point,missing-support-for-security-features-in-on-chip-fabrics-or-buses,improper-protection-for-out-of-bounds-signal-level-alerts,improperly-controlled-modification-of-object-prototype-attributes,missing-immutable-root-of-trust-in-hardware,binding-to-an-unrestricted-ip-address]).
prerequisites(accessing-functionality-not-properly-constrained-by-acls, [application-navigable-in-a-manner-that-associates-elements-of-the-application-with-acls,various-resources-discoverable-by-the-attacker,individual-urls-discoverable-by-the-attacker,administrator-have-forgotten-to-associate-an-acl,administrator-has-associated-an-inappropriately-permissive-acl-with-navigable-resource]).
execution-flow(accessing-functionality-not-properly-constrained-by-acls, [explore-survey,explore-identify-functionality,experiment-iterate-over-access-capabilities]).
mitigations(accessing-functionality-not-properly-constrained-by-acls, [in-a-j2ee-setting-administrators-can-associate-a-role,administrator-must-mark-every-non-exposed-resource,default-security-setting-must-grant-access-to-resources-intended-by-business-logic]).

%Using Malicious Files
name(using-malicious-files).
likelihood-of-attack(using-malicious-files,high).
typical-severity(using-malicious-files, very-high).
weaknesses(using-malicious-files, [incorrect-permission-assignment-for-critical-resource,improper-authorization,least-privilege-violation,improper-link-resolution-before-file-access,improper-ownership-management,permission-issues,privileges-and-access-controls,privilege-context-switching-error,protection-mechanism-failure]).
prerequisites(using-malicious-files, [allow-attacker-to-directly-access-executable-files-or-upload-files-to-execute, access-control-system-incorrectly-configured]).
mitigations(using-malicious-files, [enforce-principle-of-least-privilege,run-server-interfaces-with-a-non-root-account,pen-testing-and-vulnerability-scanning-to-identify-directories]).

%Create files with the same name as file protected with a higher classification
name(create-files-with-the-same-name-as-files-protected-with-a-higher-classification).
likelihood-of-attack(create-files-with-the-same-name-as-files-protected-with-a-higher-classification,very-high).
weaknesses(create-files-with-the-same-name-as-files-protected-with-a-higher-classification, use-of-incorrectly-resolved-name-or-reference).
prerequisites(create-files-with-the-same-name-as-files-protected-with-a-higher-classification, [target-application-must-include-external-files,located-file-found-only-by-name,the-directories-the-target-application-searches-include-directories-writable-by-the-attacker]).

%Force Use of Corrupted Files
name(force-use-of-corrupted-files).
likelihood-of-attack(force-use-of-corrupted-files,medium).
weaknesses(force-use-of-corrupted-files, inclusion-of-functionality-from-untrusted-control-sphere).
prerequisites(force-use-of-corrupted-files,[targeted-application-must-utilize-a-configuration-file,attacker-must-be-able-to-force-the-re-reading-of-the-corrupted-file]).

%Modify Shared File
name(modify-shared-file).
weaknesses(modify-shared-file, improper-access-control).
mitigations(modify-shared-file, [disallow-shared-content,protect-shared-folders-by-minimizing-users-that-have-write-access,use-utilities-that-mitigate-exploitation-like-the-microsoft-enhanced,mitigation-experience-toolkit-to-prevent-exploits-from-being-run]).

%add-malicious-file-to-shared-webroot
name(add-malicious-file-to-shared-webroot).
mitigations(add-malicious-file-to-shared-webroot,[ensure-appropriate-permissions-for-directories,disallow-remote-access-to-the-web-root,disable-execution-on-directories-within-the-web-root,ensure-that-permissions-of-the-web-server-process]).
weaknesses(add-malicious-file-to-shared-webroot,improper-access-control).

%replace-binaries
name(replace-binaries).
typical-severity(replace-binaries,high).
prerequisites(replace-binaries,placing-the-malicious-binary-on-the-target-machine).
mitigations(replace-binaries,[binaries-have-the-correct-file-permissions,set-operating-system-policies,use-auditing-tools-to-observe-changes-to-system-services]).
weaknesses(replace-binaries,incorrect-permission-assignment-for-critical-resource).

%upload-a-web-shell-to-a-web-server
name(upload-a-web-shell-to-a-web-server).
typical-severity(upload-a-web-shell-to-a-web-server,high).
prerequisites(upload-a-web-shell-to-a-web-server,web-server-must-be-susceptible-to-web-application-exploits-for-uploading-a-shell-file).
mitigations(upload-a-web-shell-to-a-web-server,[web-servers-must-be-up-to-date-with-all-patches,file-permissions-in-directories-are-set-to-the-least-privilege-settings,directories-with-files-contents-are-allowed-on-the-web-server]).
weaknesses(upload-a-web-shell-to-a-web-server,[improper-authentication,command-shell-in-externally-accessible-directory]).

%exploiting-incorrectly-configured-access-control-security-levels
name(exploiting-incorrectly-configured-access-control-security-levels).
likelihood-of-attack(exploiting-incorrectly-configured-access-control-security-levels,high).
typical-severity(exploiting-incorrectly-configured-access-control-security-levels,medium).
execution-flow(exploiting-incorrectly-configured-access-control-security-levels,[explore-survey,experiment-dentify-weak-points-in-access-control-configurations,exploit-ccess-the-function-or-data-bypassing-the-access-control]).
prerequisites(exploiting-incorrectly-configured-access-control-security-levels,[target-must-apply-access-controls-but-incorrectly-configure-them,if-the-incorrect-configuration-applies-too-much-security-it-must-prevent-legitimate-activity-and-the-attacker-must-be-able-to-force-others-to-require-this-activity]).
mitigations(exploiting-incorrectly-configured-access-control-security-levels,configure-the-access-control-correctly).
weaknesses(exploiting-incorrectly-configured-access-control-security-levels,[incorrect-permission-assignment-for-critical-resource,dma-device-enabled-too-early-in-boot-phase,exposed-chip-debug-and-test-interface-with-insufficient-or-missing-authorization,power-on-of-untrusted-execution-core-before-enabling-fabric-access-control,insufficient-granularity-of-access-control,insufficient-granularity-of-address-regions-protected-by-register-locks,improper-restriction-of-write-once-bit-fields,improper-implementation-of-lock-protection-registers,improper-hardware-lock-protection-for-security-sensitive-controls,hardware-internal-or-debug-modes-allow-override-of-locks,improper-access-to-sensitive-information-using-debug-and-test-interfaces,cpu-hardware-not-configured-to-support-exclusivity-of-write-and-execute-operations,improper-access-control-applied-to-mirrored-or-aliased-memory-regions,improper-restriction-of-security-token-assignment,improper-handling-of-overlap-between-protected-memory-ranges,register-interface-allows-software-access-to-sensitive-data-or-security-settings,insufficient-protections-on-the-volatile-memory-containing-boot-code,access-control-check-implemented-after-asset-was-accessed,improper-translation-of-security-attributes-by-fabric-bridge,hardware-allows-activation-of-test-or-debug-logic-at-runtime,improper-setting-of-bus-controlling-capability-in-fabric-end-point,fabric-address-map-allows-programming-of-unwarranted-overlaps-of-protected-and-unprotected-ranges,missing-support-for-security-features-in-on-chip-fabrics-or-buses,improper-protection-for-out-of-bounds-signal-level-alerts,improperly-controlled-modification-of-object-prototype-attributes-prototype-pollution,missing-immutable-root-of-trust-in-hardware]).

%privilege-escalation
name(privilege-escalation).
weaknesses(privilege-escalation,[improper-privilege-management,hardware-logic-with-insecure-de-synchronization-between-control-and-data-channels,improper-translation-of-security-attributes-by-fabric-bridge]).

%subvert-code-signing-facilities
name(subvert-code-signing-facilities).
likelihood-of-attack(subvert-code-signing-facilities,low).
typical-severity(subvert-code-signing-facilities,very-high).
prerequisites(subvert-code-signing-facilities,[a-framework-based-language-that-supports-code-signing,deployed-code-that-has-been-signed-by-its-authoring-vendor,placing-code-in-the-victim-container]).
mitigations(subvert-code-signing-facilities,[developers-must-never-roll-out-their-own-cryptography,avoid-reliance-on-user-controllable-flags-or-environment-variables]).
weaknesses(subvert-code-signing-facilities,[missing-cryptographic-step,reversible-one-way-hash,missing-immutable-root-of-trust-in-hardware]).

%use-of-known-domain-credentials 
name(use-of-known-domain-credentials).
likelihood-of-attack(use-of-known-domain-credentials,high).
typical-severity(use-of-known-domain-credentials,high).
execution-flow(use-of-known-domain-credentials,[explore-acquire-known-credentials,explore-determine-target-s-password-policy,explore-determine-target-s-password-policy,experiment-attempt-authentication,exploit-impersonate,exploit-spoofing,exploit-data-exfiltration]).
prerequisites(use-of-known-domain-credentials,[using-one-factor-password-based-authentication-sso-and-or-cloud-based-authentication,not-having-a-sound-password-policy,not-implement-an-effective-password-throttling-mechanism,adversary-possesses-a-list-of-known-user-accounts-and-corresponding-passwords-that-may-exist-on-the-target]).
mitigations(use-of-known-domain-credentials,[leverage-multi-factor-authentication-for-all-authentication-services,create-a-strong-password-policy,not-reusing-username/password-combinations-for-multiple-systems,not-reusing-local-administrator-account-credentials-across-systems,deny-remote-use-of-local-admin-credentials-to-log-into-domain-systems,not-allowing-accounts-to-be-a-local-administrator-on-more-than-one-system,implement-an-intelligent-password-throttling-mechanism,monitor-system-and-domain-logs-for-abnormal-credential-access]).
weaknesses(use-of-known-domain-credentials,[insufficiently-protected-credentials,improper-restriction-of-excessive-authentication-attempts,use-of-single-factor-authentication,use-of-password-system-for-primary-authentication,not-using-password-aging,password-aging-with-long-expiration,reliance-on-a-single-factor-in-a-security-decision,device-unlock-credential-sharing]).

contain(S,[]).
contain(S,[H|T]):-member(H,S), contain(S,T).

possible_attack_by_weaknesses(S,J):-weaknesses(J,S2), contain(S,S2).
possible_attack_by_mitigations(S,J):-mitigations(J,S2), contain(S,S2).
possible_attack_by_prerequisites(S,J):-prerequisites(J,S2), contain(S,S2).
possible_attack_by_execution_flow(S,J):-execution-flow(J,S2), contain(S,S2).
possible_attack_by_likelihood_of_attack(J,L):-findall(N,likelihood-of-attack(N,J),L).
possible_attack_by_typical_severity(J,L):-findall(N,typical-severity(N,J),L).

possible_mitigation_measures(N,M):-mitigations(N,M2), append([],M2,M).
possible_prerequisites(N,P):-prerequisites(N,P2), append([],P2,P).
possible_weaknesses(N,W):- weaknesses(N,W2), append([],W2,W).
execution_flow_by_attack(N,E):-execution-flow(N,E2), append([],E2,E).
